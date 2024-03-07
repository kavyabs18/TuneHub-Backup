import React, { useState } from "react";
import axios from "axios";

const App = () => {
//get request -string
const getDataFromBackend = async () => {
  const response = await axios.get("http://localhost:8080/call");
  console.log(response.data);
  document.getElementById("para").innerHTML = response.data;
};

//post request - string
const data = "Hello";
const postDataFromFrontend = async () => {
  const response = await axios.post("http://localhost:8080/testpost", {data});
  console.log(response.data);
  document.getElementById("para").innerHTML = response.data;
};

//post request-form
const[formData, setFormData] = useState("");
const postFormFromFrontend = async () => {
  const response = await axios.post("http://localhost:8080/testform", {
    formData,
  });
  console.log(response.data);
  document.getElementById("para").innerHTML = response.data;
};

  return (
  <div className="App">
    <button onClick={getDataFromBackend}>Get Data</button>
    <p id="para"></p>

    <button onClick={postDataFromFrontend}>Post Data</button>
    <p id="para"></p>

    <form onSubmit={postFormFromFrontend}>
      <label>Enter song name</label><br></br><br></br>
      <input 
        type="text" 
        name="formData" 
        value={formData} 
        onChange={(e) => setFormData(e.target.value)}
      ></input><br></br><br></br>
      <input type="submit" value="testForm"></input>
    </form>
    </div>
  );
};

export default App;