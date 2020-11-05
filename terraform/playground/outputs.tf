output "zookeeper_nodes" {
  value = module.kafka_cluster.zookeeper_nodes
}

output "kafka_brokers" {
  value = module.kafka_cluster.kafka_brokers
}

output "swarm_nodes" {
  value = module.application_stack.swarm_nodes
}

resource "local_file" "ansible_hosts" {
  filename = "./output/ansible_hosts.yml"
  content = templatefile(
    "./templates/ansible_hosts.tpl",
    {
      new_relic_license_key = var.new_relic_license_key
      zookeeper_nodes       = module.kafka_cluster.zookeeper_nodes
      kafka_brokers         = module.kafka_cluster.kafka_brokers
      swarm_nodes           = module.application_stack.swarm_nodes
      swarm_managers        = module.application_stack.swarm_managers
      swarm_workers         = module.application_stack.swarm_workers
      project_name          = var.project_name
    }
  )
}