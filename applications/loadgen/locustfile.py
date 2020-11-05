from locust import HttpUser, task, between

class MessageUser(HttpUser):
    wait_time = between(5, 30)

    @task
    def sendmessage(self):
        response = self.client.post("/sendmessage")