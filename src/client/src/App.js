import React from 'react';
import { User } from './features/user/User';
import './App.css';

function App() {
  return (
    <div className="App">
      <header>
        <h1>k8s-learn</h1>
      </header>
      
      <div className="container">
        <nav>
          <a href="#">users</a>
        </nav>
        <main>
          <User />
        </main>
      </div>
    </div>
  );
}

export default App;