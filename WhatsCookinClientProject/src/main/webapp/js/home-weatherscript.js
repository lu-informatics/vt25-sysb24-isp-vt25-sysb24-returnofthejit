window.onload = () => {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(showWeather, showError);
  } else {
    alert("Geolocation is not supported by your browser.");
  }
};

function showWeather(position) {
  const lat = position.coords.latitude;
  const lon = position.coords.longitude;
  const apiKey = "5ef220704e7065cc918f82494336d2ff";

  fetch(`https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&units=metric&appid=${apiKey}`)
    .then(res => res.json())
    .then(data => {
      document.getElementById("city").textContent = data.name;
      document.getElementById("degree").textContent = data.main.temp;
      document.getElementById("weatherType").textContent = data.weather[0].main;

      const sunrise = new Date(data.sys.sunrise * 1000).toLocaleTimeString("en-GB");
      const sunset = new Date(data.sys.sunset * 1000).toLocaleTimeString("en-GB");

      document.getElementById("sunrise").textContent = sunrise;
      document.getElementById("sunset").textContent = sunset;
    })
    .catch(() => alert("Could not retrieve weather data."));
}

function showError(error) {
  alert("Geolocation error: " + error.message);
}