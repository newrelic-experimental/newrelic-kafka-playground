output "swarm_nodes" {
  value = aws_instance.swarm_nodes
}

output "swarm_managers" {
  value = [for node in aws_instance.swarm_nodes : node if node.tags["swarm_manager"] == "true"]
}

output "swarm_workers" {
  value = [for node in aws_instance.swarm_nodes : node if node.tags["swarm_manager"] == "false"]
}