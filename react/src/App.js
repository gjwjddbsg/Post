import React from 'react';
import logo from './logo.svg';
import './App.css';
import PostList from './components/PostList'
import SavePostForm from './components/SavePostForm';

function App() {
  return (
    <div className="App">
      <PostList/>
      <SavePostForm/>
    </div>
  );
}

export default App;
