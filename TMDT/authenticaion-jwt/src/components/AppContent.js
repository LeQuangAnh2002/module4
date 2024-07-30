import React, {useState} from "react";
import WelcomeContent from "./WelcomeContent";
import AuthContent from "./AuthenContent";
import LoginForm from "./LoginForm";
import Buttons from "./Buttons";
import {request,setAuthHeader} from "../axios_helper";

export default function AppContent() {
        const [componentToShow,setComponentToShow] = useState("welcome");
        console.log(componentToShow)
        const login = () => {
            setComponentToShow( "login")
        };

    const logout = () => {
            setComponentToShow( "welcome")
            setAuthHeader(null);
        };
    const onLogin = async(e,username,password) => {
        e.preventDefault();
        try{
            const  response = await request("POST","/login",{
                login:username,password:password});

            setAuthHeader(response.data.token);
            setComponentToShow( "messages" );
        }catch (e) {
                setAuthHeader(null);
                this.setState({ componentToShow: "welcome" });
        }

    }

    const onRegister = async (e,firstName,lastName,username,password) => {
        e.preventDefault();

        try {
            const response = await request("POST","/register",
                {login:username,
                    password:password,
                    firstName:firstName,
                    lastName:lastName});
            setAuthHeader(response.data.token);
            setComponentToShow( "messages" );
        }catch (e) {
            setAuthHeader(null);
            setComponentToShow("welcome" );
        }

    };

        return(
            <div>
                <Buttons
                    login={login}
                    logout={logout}
                />

                {componentToShow ==="welcome" &&  <WelcomeContent/>}
                {componentToShow ==="login" &&  (<LoginForm onLogin={onLogin} onRegister={onRegister}/>)}
                {componentToShow ==="messages" &&  <AuthContent/>}


            </div>
        )

}