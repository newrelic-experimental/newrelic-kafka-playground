variable "aws_region" {
  type = string
}

variable "project_name" {
  type = string
}

variable "new_relic_license_key" {
  type = string
}

variable "vpc_id" {
  type    = string
  default = ""
}

variable "security_group_ids" {
  type = list(string)
}

variable "zookeeper_instance_type" {
  type = string
}

variable "zookeeper_num_nodes" {
  type = number
}

variable "kafka_instance_type" {
  type = string
}

variable "kafka_num_brokers" {
  type = number
}

variable "key_name" {
  type        = string
  description = "The name of the key pair to associate with the EC2 instances"
}