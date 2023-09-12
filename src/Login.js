import React from 'react';
import { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Login = () => {
    const [username,setUsername]=useState("");
    const [password,setPassword]=useState("");
    const [error,setError]=useState("");

    const navigate=useNavigate();

    const handleSubmit = async(e)=>{
        e.preventDefault();
        try {
            const response=await axios.post("http://localhost:8080/login",{
                username:username,
                password:password,
            });

            const role=response.data;
            if(role==="admin"){
                navigate("/admin",{state:{username:username}})
            }
            else if(role==="user"){
                navigate("/user",{state:{username:username}})
            }
            else{
                setError("Invalid Credentials");
            }
        } catch (error) {
            setError("Failed to log in");
        }

    }
        
    
    return (
        <div className='container'style={{maxWidth:"800px"}}>
          <h2 style={{marginTop:'10px'}}>Login</h2>  
          <form onSubmit={handleSubmit}>
            <div className='form-group'>
                <label htmlFor="username">Username:</label>
                <input 
                  className='form-control'
                  type='text'
                  id='username'
                  value={username}
                  onChange={(e)=>setUsername(e.target.value)}
                />
            </div>
            <div className='form-group'style={{marginTop:'20px'}}>
                <label htmlFor="password">Password:</label>
                <input
                  className='form-control'
                  type='password'
                  id='password'
                  value={password}
                  onChange={(e)=>setPassword(e.target.value)}
                />
            </div>
            <button className='btn btn-primary' type='submit'style={{marginTop:'10px'}}>
                Log In
            </button>
            {error && <div className='text-danger'>{error}</div>}
          </form>
        </div>
      );
};

export default Login;
