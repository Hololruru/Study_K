from flask import Flask
from flask import render_template, request, redirect, url_for

from todo_dao import TodoDao

app = Flask(__name__)

@app.get("/")
@app.get("/home")
def home():

    return render_template("home2.html")

@app.get("/todo/")
@app.get("/todo/list")
def todo_list():

    # 데이터베이스 데이터 조회
    todoDao = TodoDao()
    todos = todoDao.selectAllTodos()

    print(todos)

    return render_template("todo/todo-list.html", todos=todos)

@app.get("/todo/write")
def show_todo_write_form():

    return render_template("todo/todo-write.html")

@app.post("/todo/write")
def todo_write():

    title = request.form.get('title', '')
    content = request.form.get('content', '')

    todoDao = TodoDao()
    todoDao.insertTodo( (title, content) )

    # return redirect("/todo/list")
    return redirect(url_for("todo_list"))