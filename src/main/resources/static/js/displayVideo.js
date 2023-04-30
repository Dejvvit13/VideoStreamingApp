const apiUrl = 'http://localhost:8080/api/v1/videos';
const noVideosElement = document.createElement('h1');
const videoContainer = document.getElementById('video-player');

const getVideos = () => {
    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            if (data.size === 0) {
                noVideosElement.textContent = 'No videos found';
                noVideosElement.style.color = 'white';
                videoContainer.appendChild(noVideosElement);
            }
            data.forEach(video => {
                const videoElement = document.createElement('video');
                videoElement.src = video.url;
                videoElement.controls = true;
                videoElement.autoplay = false;
                videoElement.preload = 'none'
                videoElement.className = 'video-player';
                videoContainer.appendChild(videoElement);
            });
        })
        .catch(error => console.error(error));
}