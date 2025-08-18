// darkModeToggle.js

// Ensure the DOM is fully loaded before running the script
document.addEventListener("DOMContentLoaded", function() {
    // Get saved mode from localStorage
    if (localStorage.getItem('darkMode') === 'enabled') {
        document.body.classList.add('dark-mode');
    }

    // Get the toggle button by ID
    const btn = document.getElementById('darkModeToggle');

    // If button exists, attach click listener
    if (btn) {
        btn.onclick = function() {
            document.body.classList.toggle('dark-mode');

            // Save the current mode in localStorage
            if (document.body.classList.contains('dark-mode')) {
                localStorage.setItem('darkMode', 'enabled');
            } else {
                localStorage.setItem('darkMode', 'disabled');
            }
        };
    }
});
