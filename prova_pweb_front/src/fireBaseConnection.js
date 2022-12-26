import { initializeApp } from 'firebase/app'
import {getAuth} from "firebase/auth"

const firebaseConfig = {
  apiKey: "AIzaSyAS4V1-7gW3NNh6pNAzLTsYqjvyEwtZ1Xc",
  authDomain: "trabalho-inf012.firebaseapp.com",
  projectId: "trabalho-inf012",
  storageBucket: "trabalho-inf012.appspot.com",
  messagingSenderId: "803487765287",
  appId: "1:803487765287:web:3be02de6a75d2cb0ac8f02",
  measurementId: "G-NH8PWQ60VV"
};


var auth = null

const app = initializeApp(firebaseConfig)

if(app){
    auth = getAuth();
}

export default auth