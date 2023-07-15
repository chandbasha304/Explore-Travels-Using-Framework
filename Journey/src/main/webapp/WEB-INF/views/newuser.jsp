<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Explore Travels</title>
<link rel="icon" href="https://tse4.mm.bing.net/th?id=OIP.bwhluVjJTu3CJ584ObRFEAHaE8&pid=Api&P=0&h=180">
<script>
    function ab() {
        alert("Welcome to Explore Travels");
    }
</script>
<style>
    body {
        background-image: url('http://i.huffpost.com/gen/2693546/images/o-TRAVEL-facebook.jpg');
        background-size: cover;
        margin: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }
    fieldset {
        background-color: rgba(255, 255, 255, 0.8);
        border-radius: 8px;
        padding: 32px;
        width: 400px;
        text-align: center;
    }
    legend {
        color: black;
        font-size: 36px;
        text-align: center;
    }
    h1 {
        color: orange;
        font-size: 24px;
        text-align: center;
        margin-top: 32px;
    }
    form {
        display: flex;
         justify-content: center;
        flex-direction: column;
        align-items: center;
        margin-top: 24px;
    }
    label {
        color: blue;
        font-size: 16px;
        margin-bottom: 8px;
        text-align: left;
        width: 100%;
    }
    input[type="text"],
    input[type="password"],
    input[type="date"],
    select {
        border: none;
        border-radius: 4px;
        font-size: 14px;
        padding: 8px;
        margin-bottom: 8px;
        width: 100%;
        box-sizing: border-box;
    }
    button {
        background-color: #3897f0;
        border: none;
        border-radius: 4px;
        color: #fff;
        font-size: 16px;
        font-weight: bold;
        padding: 8px 16px;
        cursor: pointer;
        width: 100%;
    }
    address {
        color: darkorange;
        font-size: 20px;
        text-align: right;
        margin-top: 32px;
    }
</style>
</head>
<body>
    <fieldset>
       
            <strong style="font-size: 35px">Explore Travels</strong>
             <h1>Let's Begin The Journey With Instagram</h1>
        
        <form action="dataSending" method="post">
            <label for="fullname">Enter Your Name</label>
            <input type="text" name="fullname" placeholder="Enter Your Full Name" required>
            <label>Select Gender</label>
            <select name="gender">
                <option>Male</option>
                <option>Female</option>
            </select>
            <label for="mobilenumber">Enter Your Mobile Number</label>
            <input type="text" name="mobilenumber" placeholder="Enter Your Mobile Number" maxlength="10" required>
            <label>Enter Your Email</label>
            <input type="text" name="email" placeholder="Enter Your Email" required>
            <label>Enter Your New Password</label>
            <input type="password" name="password" placeholder="Enter Your New Password" required>
            <label>Enter Date of Birth</label>
            <input type="date" name="dob" required>
            <button onclick="ab()">Sign Up</button><br>
            <button type="reset">Cancel</button>
        </form>
    </fieldset>
   
    <address>
        Instagram Private Limited<br>
        XYZ Colony, HiTech-City<br>
        Hyderabad, Ranga Reddy District<br>
        Telangana
    </address>
</body>
</html>
