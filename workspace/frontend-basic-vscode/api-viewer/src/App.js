import './App.css';
import HttpRequestDemo from './components/HttpRequestDemo';
import NewsApiDemo from './components/NewsApiDemo';
import NewsCategories from './components/NewsCategories';
import NewsList from './components/NewsList';

function App() {
  return (
    <div>
      {/* <HttpRequestDemo /> */}
      {/* <NewsApiDemo /> */}
      {/* <NewsCategories /> */}
      <NewsList category={ "sports" } />
    </div>
  );
}

export default App;
