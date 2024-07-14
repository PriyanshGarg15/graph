In jsx expression we can never print object in it

new Date() is used to create a new Date object in JavaScript. The Date object is a built-in JavaScript object that represents a single moment in time. It provides various methods for working with dates and times.
Ex.
constnow = newDate(); console.log(now); // Outputs the current date and time

So;

function App() {
  var x = 100;
  return (
    <div>
      <nav>
        <ul>
          <li><a href="#">Home ({x + 200})</a></li>
          <li><a href="#">Images {x}</a></li>
          <li><a href="#">Videos ({new Date()})</a></li>
          <li><a href="#">Movies</a></li>
          <li><a href="#">Contact us</a></li>
        </ul>
      </nav>
      <section>
        <h1>This is section</h1>
      </section>
      <footer>
        <h1>This is footer</h1>
      </footer>
    </div>
  );
}
export default App;


We cant to this way as date returns  object in js


So do this

function App() {
  var x = 100;
  return (
    <div>
      <nav>
        <ul>
          <li><a href="#">Home ({x + 200})</a></li>
          <li><a href="#">Images {x}</a></li>
          <li><a href="#">Videos ({new Date().toString()})</a></li>
          <li><a href="#">Movies</a></li>
          <li><a href="#">Contact us</a></li>
        </ul>
      </nav>
      <section>
        <h1>This is section</h1>
      </section>
      <footer>
        <h1>This is footer</h1>
      </footer>
    </div>
  );
}
export default App;


Or use JSON.stringify

function App() {
  var x = 100;
  return (
    <div>
      <nav>
        <ul>
          <li><a href="#">Home ({x + 200})</a></li>
          <li><a href="#">Images {x}</a></li>
          <li><a href="#">Videos {JSON.stringify(new Date())}</a></li>
          <li><a href="#">Movies</a></li>
          <li><a href="#">Contact us</a></li>
        </ul>
      </nav>
      <section>
        <h1>This is section</h1>
      </section>
      <footer>
        <h1>This is footer</h1>
      </footer>
    </div>
  );
}
export default App;



Code to make basic html css page in App.js


function App() {
  return (
    <div>
      <nav style={{
        width: "100%",
        backgroundColor: "red"
      }}>
        <ul style={{
          padding: 0,
          margin: 0,
          display: 'flex',
          listStyle: 'none',
          justifyContent: 'space-evenly'
        }}>
          <li>
            <a href="#" style={{
              textDecoration: 'none',
              color: 'white',
              padding: '8px',
              display: 'block',
              fontSize: 18
            }}>Home</a>
          </li>
          <li>
            <a href="#" style={{
              textDecoration: 'none',
              color: 'white',
              padding: '8px',
              display: 'block',
              fontSize: 18
            }}>Images</a>
          </li>
          <li>
            <a href="#" style={{
              textDecoration: 'none',
              color: 'white',
              padding: '8px',
              display: 'block',
              fontSize: 18
            }}>Videos</a>
          </li>
          <li>
            <a href="#" style={{
              textDecoration: 'none',
              color: 'white',
              padding: '8px',
              display: 'block',
              fontSize: 18
            }}>Movies</a>
          </li>
          <li>
            <a href="#" style={{
              textDecoration: 'none',
              color: 'white',
              padding: '8px',
              display: 'block',
              fontSize: 18
            }}>Contact us</a>
          </li>
        </ul>
      </nav>
      <section style={{
        width: '75%',
        padding: 34,
        background: '#f5f5f5',
        margin: '48px auto',
        textAlign:'center'
      }}>
        <h1>This is section</h1>
      </section>
      <footer style={{
        background: '#323232',
        textAlign: 'center',
        color: 'white',
        padding: 100
      }}>
        <h1>This is footer</h1>
      </footer>
    </div>
  );
}
export default App;

![image](https://github.com/PriyanshGarg15/React_2.0/assets/116974262/79f2b328-5496-47a2-81bd-d722099c93ee)




Rememebr=we should not use <a> tag in react

In React, it is generally not recommended to use the <a> tag for internal navigation because it causes a full page reload, which defeats the purpose of a single-page application (SPA). Instead, you should use a component that integrates with React's routing system, such as the <Link> component from the react-router-dom library.

import React from 'react';
import { Link } from 'react-router-dom';

function App() {
  var x = 100;

  return (
    <div>
      <nav style={{
        width: "100%",
        backgroundColor: "red"
      }}>
        <ul style={{
          padding: 0,
          margin: 0,
          display: 'flex',
          listStyle: 'none',
          justifyContent: 'space-evenly'
        }}>
          <li>
            <Link to="/" style={{
              textDecoration: 'none',
              color: 'white',
              padding: '8px',
              display: 'block',
              fontSize: 18
            }}>Home ({x + 200})</Link>
          </li>
          <li>
            <Link to="/images" style={{
              textDecoration: 'none',
              color: 'white',
              padding: '8px',
              display: 'block',
              fontSize: 18
            }}>Images {x}</Link>
          </li>
          <li>
            <Link to="/videos" style={{
              textDecoration: 'none',
              color: 'white',
              padding: '8px',
              display: 'block',
              fontSize: 18
            }}>Videos ({new Date().toString()})</Link>
          </li>
          <li>
            <Link to="/movies" style={{
              textDecoration: 'none',
              color: 'white',
              padding: '8px',
              display: 'block',
              fontSize: 18
            }}>Movies</Link>
          </li>
          <li>
            <Link to="/contact" style={{
              textDecoration: 'none',
              color: 'white',
              padding: '8px',
              display: 'block',
              fontSize: 18
            }}>Contact us</Link>
          </li>
        </ul>
      </nav>

      <section style={{
        width: '75%',
        padding: 34,
        background: '#f5f5f5',
        margin: '48px auto'
      }}>
        <h1>This is section</h1>
      </section>

      <footer style={{
        background: '#323232',
        textAlign: 'center',
        color: 'white',
        padding: 100
      }}>
        <h1>This is footer</h1>
      </footer>
    </div>
  );
}

export default App;



But we will not do this way as a single component(App.js) as it create a lot messyness we will make different components:-
