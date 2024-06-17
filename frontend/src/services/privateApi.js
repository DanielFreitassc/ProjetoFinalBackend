import axios from "axios";

export const privateAPi = axios.create({
    baseURL: "http://localhost:8080",
});

privateAPi.interceptors.request.use((config) => {
    const token = localStorage.getItem("authToken");
    const customConfig = config;

    if (token) customConfig.headers.Authorization = `Bearer ${token}`;

    return customConfig;
});