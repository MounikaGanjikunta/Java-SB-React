import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "/node_modules/bootstrap/dist/js/bootstrap.min.js"
import './App.css';
import Home from './Home';
import StudentsView from './Component/Student/StudentsView';
import Navbar from "./Component/common/Navbar";
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import AddStudent from "./Component/Student/AddStudent";
import EditStudent from "./Component/Student/EditStudent";
import StudentProfile from "./Component/Student/StudentProfile";


function App() {
  return (
    <main className="container mt-5">
      
      <Router>
      <Navbar/>
        <Routes>
          <Route exact path= "/" element = {<Home/>}></Route>
          <Route exact path= "/view-students" element = {<StudentsView/>}></Route>
          <Route exact path= "/student-profile/:id" element = {<StudentProfile/>}></Route>
          <Route exact path= "/edit-student/:id" element = {<EditStudent/>}></Route> 
          <Route exact path= "/add-student" element = {<AddStudent/>}></Route>
          
        </Routes>
      </Router>

    </main>
  );
}

export default App;
