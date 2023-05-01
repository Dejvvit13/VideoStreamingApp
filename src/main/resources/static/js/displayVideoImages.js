const apiUrl = 'http://localhost:8080/api/v1/videos';
const videoContainer = document.getElementById('video-show');

fetch(apiUrl)
    .then(response => response.json())
    .then(data => {
        console.log(data.content)
        if (data.content.length > 0) {
            data.content.forEach(video => {
                const mainContainer = document.createElement('div');
                initVideoImageContainer(mainContainer, video);

            });
        } else {
            createNoVideosView();
        }
    })
    .catch(error => console.error(error));

function initVideoImageContainer(mainContainer, video) {
    mainContainer.addEventListener('click', () => redirectTo(video.videoUrl));
    mainContainer.id = 'video-container';
    mainContainer.style.backgroundImage = `url(${video.imageUrl})`;
    addTitleToVideoContainer(mainContainer, video);
    videoContainer.appendChild(mainContainer);
}

function addTitleToVideoContainer(mainContainer, video) {
    const titleContainer = document.createElement('div');
    const title = document.createElement('p');
    titleContainer.id = 'title-container';
    title.textContent = video.title;
    titleContainer.appendChild(title);
    mainContainer.appendChild(titleContainer);
}

function createNoVideosView() {
    const noVideosElement = document.createElement('h2');
    videoContainer.style.alignContent = 'center';
    videoContainer.style.justifyContent = 'center';
    noVideosElement.textContent = 'No videos found';
    noVideosElement.style.color = 'white';
    videoContainer.appendChild(noVideosElement);
}

function redirectTo(url) {
    window.location = url;
}