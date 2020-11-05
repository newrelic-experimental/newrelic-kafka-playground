terraform {
  required_providers {
    aws = {
      source = "hashicorp/aws"
    }
  }
}

provider "aws" {
  profile = var.aws_profile
  region  = var.aws_region
}

data "aws_vpc" "default" {
  default = true
}

locals {
  vpc_id = var.vpc_id == "" ? data.aws_vpc.default.id : var.vpc_id
}

module "kafka_cluster" {
  source                  = "../modules/kafka-cluster"
  project_name            = var.project_name
  new_relic_license_key   = var.new_relic_license_key
  aws_region              = var.aws_region
  vpc_id                  = var.vpc_id
  security_group_ids      = [aws_security_group.kafka_playground_sg.id]
  zookeeper_instance_type = var.zookeeper_instance_type
  zookeeper_num_nodes     = var.zookeeper_num_nodes
  kafka_instance_type     = var.kafka_instance_type
  kafka_num_brokers       = var.kafka_num_brokers
  key_name                = var.ec2_keypair_name
}

module "application_stack" {
  source                = "../modules/application-stack"
  project_name          = var.project_name
  new_relic_license_key = var.new_relic_license_key
  aws_region            = var.aws_region
  vpc_id                = var.vpc_id
  security_group_ids    = [aws_security_group.kafka_playground_sg.id]
  instance_type         = var.application_stack_instance_type
  num_nodes             = var.application_stack_num_nodes
  key_name              = var.ec2_keypair_name
}