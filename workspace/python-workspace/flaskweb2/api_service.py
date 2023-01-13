from flask import Flask

app = Flask(__name__) # web application 

@app.get("/")
def home():
    return "home"