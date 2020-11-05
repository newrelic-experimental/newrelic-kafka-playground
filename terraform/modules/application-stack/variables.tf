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

variable "instance_type" {
  type = string
}

variable "num_nodes" {
  type = number
}

variable "key_name" {
  type        = string
  description = "The name of the key pair to associate with the EC2 instances"
}