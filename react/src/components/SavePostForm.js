import React, { useState, useEffect } from 'react'
import axios from 'axios'

export default function () {
    const [post, setPost] = useState({
        title : "title", content : "content", author : "author"
    })

    const savePost = () => {
        console.log("xxxxxxx")
        axios.post("http://localhost:8080/post", post)
    }
    const change= e => {
        const data = e.target;
        console.log(data.name)
        console.log(data.value)
        setPost({
            ...post,
            [data.name]:data.value
        })
    }


    return (
        <div>
            title : <input type="text" id="title" name="title" onChange={change}></input> &nbsp;
            content : <input type="text" id="content" name="content" onChange={change}></input> &nbsp;
            author : <input type="text" id="author" name="author" onChange={change}></input> &nbsp;
            <button onClick={savePost}>등록</button>
        </div>
    )
}

