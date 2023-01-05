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


@app.post("/game1")
def game1():
    user = int(request.form.get('selection', 0))

    if user == 0:
        return "Invalid User Selection"

    import random
    com = random.randint(1, 3)

    result = None
    if (user == 1 and com == 3) or \
       (user == 2 and com == 1) or \
       (user == 3 and com == 2):
       result = 'User Win'
    elif user == com:
        result = "Draw"
    else:
        result = "Computer Win"
        
    return "RESULT : {0}".format(result)

@app.post("/lotto")
def select_golden_numbers():
    import random
    cnt = request.form.get("cnt", 1)
    try:
        cnt = int(cnt)
    except:
        cnt = 1

    numbers_list = []
    for rnd in range(cnt):
        numbers = []
        while True:
            number = random.randint(1, 45)
            if number not in numbers:
                numbers.append(number)
            
            if len(numbers) == 6:
                break
                        
        numbers = sorted(numbers)
        numbers_list.append(numbers)

    return render_template('lotto-result.html', numbers_list=numbers_list)
    
