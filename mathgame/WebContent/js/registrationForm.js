

// Method to validate all fields of the Form when user enters the value. 
function validateForm(){	
	var userName = document.getElementById("userName"); 
	var firstName = document.getElementById("firstName");
	var lastName = document.getElementById("lastName"); 
	var postCode = document.getElementById("postCode"); 
	var email = document.getElementById("email"); 
	var password = document.getElementById("password"); 
	var reEnterPassword = document.getElementById("reEnterPassword"); 
	
	var userNameError = document.getElementById("userNameError"); 
	userNameError.innerHTML = '<img src = "images/check.jpg" width = "15" height = "15">'; 
	if(userName.value == "") {
		userNameError.innerHTML = "User Name is required.";
		userName.focus(); 
		return false;		
	}
	
	if(userName.value.length <4 || userName.value.length >8){
		userNameError.innerHTML = "User Name is not valid.";
		userName.focus(); 
		return false;	
	}
	
	
		
	// Validate the First Name field and ensure it is filled in. 
	var firstNameError = document.getElementById("firstNameError"); 	
	firstNameError.innerHTML = '<img src = "images/check.jpg" width = "15" height = "15">'; 
	if(firstName.value == ""){		
		firstNameError.innerHTML = "First Name is required.";
		firstName.focus(); 
		return false; 
	}	
	// Validate the Last Name field and ensure it is filled in.
	var lastNameError = document.getElementById("lastNameError"); 
	lastNameError.innerHTML = '<img src = "images/check.jpg" width = "15" height = "15">'; 
	if(lastName.value == ""){		
		lastNameError.innerHTML = "Last Name is required.";
		lastName.focus(); 
		return false; 
	} 
	// Validate Post Code field. Ensured it is filled in with 4 numbers. 
	var postCodeError = document.getElementById("postCodeError"); 
	postCodeError.innerHTML = '<img src = "images/check.jpg" width = "15" height = "15">'; 
	if(postCode.value.length != 4 || isNaN(postCode.value)){
		if(postCode.value.length == 0){
			postCodeError.innerHTML = "Postcode is required."
		} else {
			postCodeError.innerHTML = "Postcode is invalid."
		}		
		postCode.focus(); 
		return false; 
	}	
	/* Validate the Email field. Ensure it is filled with at least 1 '@' and '.' character
	 * Also ensure its length is not less than 8.  
	 */
	var emailError = document.getElementById("emailError"); 
	emailError.innerHTML = '<img src = "images/check.jpg" width = "15" height = "15">'; 
	if (email.value.length < 8 || email.value.indexOf("@") == -1 || email.value.indexOf(".") == -1){
		if (email.value.length==0){
			emailError.innerHTML = "Email address is required." 
		} else {
			emailError.innerHTML = "Email address is invalid." 
		}		
		email.focus(); 
		return false; 
	}	
	
	
	var passwordError = document.getElementById("passwordError"); 
	passwordError.innerHTML = '<img src = "images/check.jpg" width = "15" height = "15">'; 
	if(password.value.length < 6 || password.value.length > 8) {
		passwordError.innerHTML = "Password is invalid"; 
		password.focus(); 
		return false; 
	}
	
	var reEnterPasswordError = document.getElementById("reEnterPasswordError"); 
	reEnterPasswordError.innerHTML = '<img src = "images/check.jpg" width = "15" height = "15">'; 
	if(reEnterPassword.value != password.value ) {
		reEnterPasswordError.innerHTML = "Wrong password re-entered."; 
		reEnterPassword.focus(); 
		return false; 
	}
	
	
	document.getElementById("controlServlet").value = "VALID_REGISTRATION"; 
	
	return true; 	
}
// Method to change background-color and foreground-color when text boxes get focus. 
function changeBgd(textField){
	textField.style.background = "yellow"; 
	textField.style.color = "blue"; 
}
// Method to change background-color when text boxes lose focus. 
function resetBgd(textField){
	textField.style.background = "lightgrey"; 
	textField.style.color = "black"; 
}
// Method to open new page to instruct user how to fill the form correctly
function help(){
	window.open("help-page.html","_blank","width=500, height = 500");
}

function logInToPlay(){
	window.location.replace("login.jsp", "_blank"); 
}

function playAsGuest(){
	window.location.replace("math-game-guest.jsp","_blank");
}

function reloadRegistration(){
	window.location.replace("registration-form.jsp", "_blank"); 
}

// Method to reload the page and get ready for next user. 
function reload(){
	location.reload(); 
}