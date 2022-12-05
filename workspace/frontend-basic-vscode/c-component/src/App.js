import logo from './logo.svg';
import './App.css';
import ClassComponent from './ClassComponent';
import FunctionComponent from './FunctionComponent';
import ClassComponent2 from './ClassComponent2';
import FunctionComponent2 from './FunctionComponent2';

function App() {
  return (
    <>
      <br /><br />
      <h2>React Component Demo</h2>
      <hr />
      <ClassComponent name="John Doe"
                      email="johndoe@example.com"
                      age="29" />
      <ClassComponent2 />
      <FunctionComponent name="Jane Doe"
                         email="janedoe@example.com"
                         age="26" />
      <FunctionComponent2 />
    </>
  );
}

export default App;
