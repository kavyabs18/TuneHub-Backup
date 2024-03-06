import React from "react";

export default function Login(){
    return (<div>
        <form action="validate" method="post">
		<h2>USER LOGIN</h2>
		
		<label><b>Email:</b></label><br /> 
		<input type="email" name="email" /><br /><br />
		
		<label><b>Password:</b></label><br />
		<input type="password" name="password" /><br /><br />
		
		<input type="submit" value="LOGIN" id="log" />
	</form>
    </div>);
}