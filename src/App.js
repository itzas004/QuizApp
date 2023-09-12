import React from "react";
import Login from "./Login";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import QuizPage from "./QuizPage";
import AdminLogin from "./AdminLogin";
import ShowQuestions from "./ShowQuestions";
import QuizGenerator from "./QuizGenerator";
import ShowUserResponse from "./ShowUserResponse";

function App() {
  return (
    <Router>
      <Routes>
        <Route path='/' element={<Login/>}/>
        <Route path='/admin' element={<AdminLogin/>}/>
        <Route path='/user' element={<QuizPage/>}/>
        <Route path='/admin/show-question' element={<ShowQuestions/>}/>
        <Route path='/admin/generate-quiz' element={<QuizGenerator/>}/>
        <Route path='/admin/validate-answer' element={<ShowUserResponse/>}/>
      </Routes>
    </Router>
  );
}

export default App;
