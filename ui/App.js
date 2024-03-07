import React, { useState } from "react";
import axios from "axios";

const App = () => {
//post request-form
const[songName, setSongName] = useState("");
const[songArtist, setSongArtist] = useState("");
const[songGenre, setSongGenre] = useState("");
const[songLink, setSongLink] = useState("");

const postFormFromFrontend = async () => {
  const response = await axios.post("http://localhost:8080/testform", {
    songName,
    songArtist,
    songGenre,
    songLink,
  });
  console.log(response.data);
  document.getElementById("para").innerHTML = response.data;
};

  return (
  <div className="App">
    <form onSubmit={postFormFromFrontend}>
      <label>Song Name:</label><br></br><br></br>
      <input 
        type="text" 
        name="songName" 
        placeholder="Enter Song Name"
        value={songName} 
        onChange={(e) => setSongName(e.target.value)}
      ></input><br></br><br></br>

      <label>Song Artist:</label><br></br><br></br>
      <input 
        type="text" 
        name="songArtist" 
        placeholder="Enter Song Artist"
        value={songArtist} 
        onChange={(e) => setSongArtist(e.target.value)}
      ></input><br></br><br></br>

      <label>Song Genre:</label><br></br><br></br>
      <input 
        type="text" 
        name="songGenre" 
        placeholder="Enter Song Genre"
        value={songGenre} 
        onChange={(e) => setSongGenre(e.target.value)}
      ></input><br></br><br></br>

      <label>Song Link:</label><br></br><br></br>
      <input 
        type="text" 
        name="songLink" 
        placeholder="Enter Song Link"
        value={songLink} 
        onChange={(e) => setSongLink(e.target.value)}
      ></input><br></br><br></br>

      <input type="submit" value="ADD SONG"></input>
    </form>
    </div>
  );
};

export default App;