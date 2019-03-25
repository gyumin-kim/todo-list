async function init() {
  const registration = await navigator.serviceWorker.register('firebase-messaging-sw.js');
  await navigator.serviceWorker.ready;
  let config = {
    apiKey: "AIzaSyAruBt0_-qHESxnpQOfW_H4Cea6kwjpuy4",
    authDomain: "todo-list-99375.firebaseapp.com",
    databaseURL: "https://todo-list-99375.firebaseio.com",
    projectId: "todo-list-99375",
    storageBucket: "todo-list-99375.appspot.com",
    messagingSenderId: "500252436805"
  };
  firebase.initializeApp(config);

  const messaging = firebase.messaging();
  messaging.usePublicVapidKey(
      'BIdd2ldZjZ3kXn39v3eeFpdQz3W5KAzTQ8FgzzQpzIttOIebYN6DCpiMUl_Trmcdal_WDyxWHmfF9Ws4o2o3R0A');
  messaging.useServiceWorker(registration);

  try {
    await messaging.requestPermission();
  } catch (e) {
    console.log('Unable to get permission', e);
    return;
  }

  navigator.serviceWorker.addEventListener('message', event => {
    // if (event.data === 'newData') {
    //   showData();
    // }
  });

  const currentToken = await messaging.getToken();
  console.log(`currentToken: ${currentToken}`);
  fetch('/register', {
    method: 'post',
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(currentToken),
  });
  // showData();

  messaging.onTokenRefresh(async () => {
    console.log('token refreshed');
    const newToken = await messaging.getToken();
    console.log(`newToken: ${newToken}`);
    fetch('/register', {
      method: 'post',
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(currentToken),
    });
  });

}

// async function showData() {
//   const db = await getDb();
//   const tx = db.transaction('jokes', 'readonly');
//   const store = tx.objectStore('jokes');
//   store.getAll().onsuccess = e => showJokes(e.target.result);
// }

// function showJokes(jokes) {
//   const table = document.getElementById('outTable');
//
//   jokes.sort((a, b) => parseInt(b.ts) - parseInt(a.ts));
//   const html = [];
//   jokes.forEach(j => {
//     const date = new Date(parseInt(j.ts));
//     html.push(
//         `<div><div class="header" style="font-family: monospace; font-size: 1.1em;">${date.toISOString()} ${j.id} (${j.seq})</div><div class="joke" style="margin-bottom: 10px;">${j.joke}</div></div>`);
//   });
//   table.innerHTML = html.join('');
// }

// async function getDb() {
//   if (this.db) {
//     return Promise.resolve(this.db);
//   }
//   return new Promise(resolve => {
//     const openRequest = indexedDB.open("Chuck", 1);
//
//     openRequest.onupgradeneeded = event => {
//       const db = event.target.result;
//       db.createObjectStore('jokes', {keyPath: 'id'});
//     };
//
//     openRequest.onsuccess = event => {
//       this.db = event.target.result;
//       resolve(this.db);
//     }
//   });
// }

// init();