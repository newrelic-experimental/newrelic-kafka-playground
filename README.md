[![New Relic Experimental header](https://github.com/newrelic/opensource-website/raw/master/src/images/categories/Experimental.png)](https://opensource.newrelic.com/oss-category/#new-relic-experimental)

# New Relic Kafka Playground

This project contains a set of Terraform configurations and Ansible playbooks that will deploy to AWS a complete Kafka cluster (including Zookeeper), as well as a set of producer and consumer applications running in a Docker Swarm cluster.   It is fully configured and instrumented with New Relic.

You'll see how New Relic provides observability into Kafka clusters as well as producer and consumer applications in a simulation of a real-world asynchronous messaging scenario.  It is completely configurable and extensible, allowing you to scale your cluster size and to modify/redeploy the applications to experiment with the features of the New Relic platform and how they relate to messages passed via Kafka streams.

In addition to instrumenting Kafka with the [New Relic Kafka On-Host Integration](https://docs.newrelic.com/docs/integrations/host-integrations/host-integrations-list/kafka-monitoring-integration), all hosts and containers are instrumented with the [New Relic Infrastructure Agent](https://docs.newrelic.com/docs/infrastructure), which also collects [Logs](https://newrelic.com/products/logs) from both the Kafka brokers as well as the producers and consumers.  The applications are instrumented with [New Relic APM](https://docs.newrelic.com/docs/apm), and [Distributed Tracing](https://docs.newrelic.com/docs/understand-dependencies/distributed-tracing/get-started/introduction-distributed-tracing) has been enabled between producers and consumers along with the capability of viewing [logs in context](https://docs.newrelic.com/docs/logs/enable-log-management-new-relic/configure-logs-context/configure-logs-context-apm-agents).

## Installation

Follow the instructions in ["Building the Cluster"](./doc/building-the-cluster.md)

## Contributing
We encourage your contributions to improve New Relic Kafka Playground! Keep in mind when you submit your pull request, you'll need to sign the CLA via the click-through using CLA-Assistant. You only have to sign the CLA one time per project.
If you have any questions, or to execute our corporate CLA, required if your contribution is on behalf of a company,  please drop us an email at opensource@newrelic.com.

**A note about vulnerabilities**

As noted in our [security policy](../../security/policy), New Relic is committed to the privacy and security of our customers and their data. We believe that providing coordinated disclosure by security researchers and engaging with the security community are important means to achieve our security goals.

If you believe you have found a security vulnerability in this project or any of New Relic's products or websites, we welcome and greatly appreciate you reporting it to New Relic through [HackerOne](https://hackerone.com/newrelic).

## License
New Relic Kafka Playground is licensed under the [Apache 2.0](http://apache.org/licenses/LICENSE-2.0.txt) License.
