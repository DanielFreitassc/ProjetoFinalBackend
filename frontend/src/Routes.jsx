import { createBrowserRouter } from "react-router-dom";
import { Home } from "./screens/Home";
import { Header } from "./components/Header";
import { Products } from "./screens/Products";
import { Waste } from "./screens/Waste";
import { Sensor } from "./screens/Sensor";
import { AuthProvider } from "./context/AuthProvider";
import Login from "./screens/Login";

export const AppRoutes = createBrowserRouter([
    {
        path:"/home",
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
    },
    {
      path:"/",
      element: (
        <AuthProvider>
          <Login/>
        </AuthProvider>
      )
    },
])