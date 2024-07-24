<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fun Games - Home</title>
    <link rel="stylesheet" href="./styles.css">
</head>
<body>
    <ul class="navbar">
        <li><a href="./home.jsp">🏠 Home</a></li>
        <li><a href="../Registration/index.html"> Sign Up</a></li>
        <%-- Check if user is signed in to show Sign In or Logout --%>
        <%   session=request.getSession(false); // Do not create a new session if one doesn't exist %>
        <% if (session != null && session.getAttribute("name") != null) {  %>
        <li><a href="./index.html">🔑 Sign In</a></li>
        <% } else { %>
        <li><a href="./index.html">🔑 Sign In</a></li>
        <% } %>
        <li><a href="./contact.html">📞 Contact</a></li>
    </ul>
    <h1>Welcome to Fun Games 🎉</h1>
    <p>Explore our delightful collection of whimsical web games. From "The Fluffy Scale" to "Randomness Roulette," laughter awaits! 😄</p>

    <!-- Additional Content Section -->
    <div class="games-section">
        <h2 style="margin-bottom: 30px;">Popular Games 🕹️</h2>
        <div class="game-box">
            <h3>Rock Paper Scissors</h3>
            <p>A classic game of strategy and luck. Test your skills against the computer!</p>
            <%-- Check if user is signed in to show Play Now --%>
            <% if (session != null && session.getAttribute("name") != null) { %>
            <a href="../RockPaperScissor/index.html">Play Now</a>
            <% } else { %>
            <button><span>Please sign in to play</span></button>
            <% } %>
        </div>
        <div class="game-box">
            <h3>Guess a Number</h3>
            <p>Think you can guess the right number? Try your luck in this thrilling game!</p>
            <%-- Check if user is signed in to show Play Now --%>
            <% if (session != null && session.getAttribute("name") != null) { %>
            <a href="../GuessANumber/index.html">Play Now</a>
            <% } else { %>
            <button><span>Please sign in to play</span></button>
            <% } %>
        </div>
    </div>
    <!-- End of Additional Content Section -->
    
    <!-- Footer Section (optional) -->
    <footer>
        <p>&copy; 2024 Fun Games. All rights reserved.</p>
    </footer>
</body>
</html>
