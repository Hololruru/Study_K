from flask import Flask

from flask import render_template

app = Flask(__name__)

# @app.route("/", methods=['GET'])
@app.get("/")
@app.get("/home")
def home():
    return render_template("home.html")