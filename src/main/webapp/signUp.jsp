<!DOCTYPE html>
<html>
<head>
    <title>Signup Form</title>
    <script type="text/javascript">
        function validateForm() {
            // Get form inputs
            var name = document.getElementById("name").value;
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var mobile = document.getElementById("mobile").value;
            var email = document.getElementById("email").value;

            // Perform validation
            if (name === "" || username === "" || password === "" || mobile === "" || email === "") {
                alert("Please fill in all fields");
                return false;
            }

            // Validate username (must be at least 6 characters)
            if (username.length < 6) {
                alert("Username must be at least 6 characters");
                return false;
            }

            // Validate mobile number (must be numeric and 10 digits)
            if (isNaN(mobile) || mobile.length !== 10) {
                alert("Mobile number should be 10 digits only");
                return false;
            }

            // Validate email format
            var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!email.match(emailRegex)) {
                alert("Invalid email address");
                return false;
            }

            // Form is valid, submit it
            return true;
        }
    </script>
</head>
<body>
    <h2>Signup Form</h2> 
    <form method="post" action="signupValidation" onsubmit="return validateForm()">
        <label for="name">Name : </label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="username">Username :</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Password : </label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="mobile">Mobile Number : </label>
        <input type="text" id="mobile" name="mobile" required><br><br>

        <label for="email">Email : </label>
        <input type="email" id="email" name="email" required><br><br>

        <input type="submit" value="Signup">
    </form>
</body>
</html>
