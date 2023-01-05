from flask import Flask

from flask import render_template, request

app = Flask(__name__)

# @app.route("/", methods=['GET'])
@app.get("/")
@app.get("/home")
def home():
    return render_template("home.html")

@app.get("/request-data-test")
def process_get_request():
    email = request.args['email']
    # passwd = request.args['passwd'] # key가 없으면 key error 발생
    passwd = request.args.get('passwd', 'password not specified')

    return "GET: Email : {0} / Password : {1}".format(email, passwd)

@app.post("/request-data-test")
def process_post_request():
    email = request.form['email']
    passwd = request.form['passwd']

    return "POST: Email : {0} / Password : {1}".format(email, passwd)
    pass