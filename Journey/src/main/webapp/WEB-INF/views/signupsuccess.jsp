<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Explore Travels - Book Tickets</title>
<script type="text/javascript">
	function logout() {
		
		
		 confirm("Are You Sure Want To Logout");
		 
	}
</script>
<style>
body {
	background-image: url('https://wallpapercave.com/wp/wp8705605.jpg');
	background-size: cover;
	margin: 0;
	padding: 10px;
	font-family: Arial, sans-serif;
}

.container {
	display: grid;
	grid-template-columns: repeat(3, 1fr);
	grid-gap: 20px;
	justify-items: center;
}

.item {
	text-align: center;
}

.image {
	width: 100%;
	height: 200px;
	object-fit: cover;
	border-radius: 8px;
}

.title {
	color: white;
	text-align: center;
	margin-top: 30px;
}

.subtitle {
	color: white;
	text-align: center;
	margin-bottom: 30px;
}

h1 {
	color: orange;
}

.date-input {
	display: flex;
	justify-content: center;
	margin-top: 20px;
	color: white;
	font-weight: bold;
}

p {
	color: aqua;
}

.date-input label {
	margin-right: 10px;
}

.date-input input[type="text"], .date-input input[type="date"] {
	padding: 5px;
	border-radius: 5px;
	border: none;
	outline: none;
}
</style>
</head>
<body>
	<h1 class="title">Welcome To Explore Travels</h1>
	<h2 class="subtitle">Book Tickets</h2>
	<div class="date-input">
		<form action="journey" method="post">
			<label>From Place</label> <input type="text" name="from"
				placeholder="From Place"> <label>ToPlace</label> <input
				type="text" name="to" placeholder="To Place"> <label>Select
				Date</label> <input type="date" name="date">
			<button>Search</button>
		</form>
	</div>
	<h1>Welcome, ${fullname}!</h1>
	<p>Offering Unmatched Services to Hyderabad, Bangalore,Chennai,
		Vijayawada, Vizag, Kochi, and More!</p>
	<h1>Welcome, ${name}!</h1>



	<div class="container">
		<div class="item">
			<img
				src="https://dd0w3jaz1pep7.cloudfront.net/assets/images/tourism/poi/Vijayawada/prakasam-barrage-vijayawada-503c7dca77881b192c000917.jpg"
				alt="Vijayawada" class="image">
			<h1>Vijayawada</h1>
		</div>
		<div class="item">
			<img
				src="https://cdn.wallpaperhub.app/cloudcache/a/a/0/e/4/e/aa0e4e5bd45e7157d3081a5fdedaef4bdce47c52.jpg"
				alt="Forest" class="image">
			<h1>Hyderabad</h1>
		</div>
		<div class="item">
			<img
				src="https://preview.redd.it/iyhygkj6h8931.jpg?auto=webp&s=36b8cfc7daba4c1e53c1dd9f0fa2f21d4c84cbc5"
				alt="Mountains" class="image">
			<h1>Bangalore</h1>
		</div>
		<div class="item">
			<img
				src="https://2.bp.blogspot.com/-BcKBgE1S-bs/UVBz-XxPw9I/AAAAAAAAfnc/3iBhhbx_s-Y/s1600/Chennai+Madras+India+3.jpg"
				alt="Chennai" class="image">
			<h1>Chennai</h1>
		</div>
		<div class="item">
			<img
				src="https://static.india.com/wp-content/uploads/2020/09/KERALA1200.jpg"
				alt="Kerala" class="image">
			<h1>Kerala</h1>
		</div>
		<div class="item">
			<img
				src="https://live.staticflickr.com/1759/28654102158_47e5f69dc4_b.jpg"
				alt="Mountains" class="image">
			<h1>Vishakapatnam</h1>
		</div>
	</div>
	<div style="color: aqua;">
		<p>Trust Explore Travels for Tailored Services, Hassle-Free
			Bookings, Comfortable Transportation, Personalized Itineraries, and
			an Unforgettable Travel Eperience. Book Now and Discover your desired
			Destination!</p>
		<p>Embark on a Journey with us and Experience the Rich History of
			Hyderabad, the Cultural Hub of Chennai, the Breathtaking Landscapes
			of Vijayawada, the Coastal Paradise of Vizag, the Vibrant City Life
			of Kochi, and the Bustling Atmosphere of Chennai.</p>
	</div>


	<button onclick="logout()">
		<a href="logout">Logout</a>
	</button>
</body>
</html>
