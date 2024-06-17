import { createBrowserRouter } from "react-router-dom";
import { Home } from "./screens/Home";
import { Header } from "./components/Header";
import { Products } from "./screens/Products";
import { Waste } from "./screens/Waste";
import { Sensor } from "./screens/Sensor";

export const AppRoutes = createBrowserRouter([
    {
        path:"/",
        element: 
        <>
            <Header/>
            <Home/>
        </>
    },
    {
        path:"/produtos",
        element: 
        <>
            <Header/>
            <Products/>
        </>
    },
    {
        path:"/desperdicio",
        element: 
        <>
            <Header/>
            <Waste/>
        </>
    },
    {
        path:"/sensor",
        element: 
        <>
            <Header/>
            <Sensor/>
        </>
    }
])