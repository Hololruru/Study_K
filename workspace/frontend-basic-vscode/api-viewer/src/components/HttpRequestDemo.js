import { useState } from 'react';
import axios from 'axios';

const HttpRequestDemo = (props) => {

    const [data, setData] = useState(null);

    const clickHandler1 = (e) => {
        axios.get("https://jsonplaceholder.typicode.com/todos/2")
             .then( (response) => {
                setData(response.data);
             });
    };

    return (
        <div>
            <button onClick={clickHandler1}>데이터 가져오기 1</button>
            <button>2</button>
            <hr />
            <div>
                { data ? JSON.stringify(data) : "버튼을 클릭해서 데이터를 요청하세요" }
            </div>
        </div>
    );

};

export default HttpRequestDemo;