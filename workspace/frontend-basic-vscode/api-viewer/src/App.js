import './App.css';
import HttpRequestDemo from './components/HttpRequestDemo';
import NewsApiDemo from './components/NewsApiDemo';
import NewsCategories from './components/NewsCategories';

function App() {
  return (
    <div style={{ padding: 20}}>
      {/* <HttpRequestDemo /> */}
      {/* <NewsApiDemo /> */}
      <NewsCategories />
    </div>
  );
}

export default App;
