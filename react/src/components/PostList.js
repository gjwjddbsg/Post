import React, { useState, useEffect } from 'react'
import axios from 'axios'


export default function PostList() {

    const [posts, setPosts] = useState([])
    
    useEffect(() => {
        axios.get("http://localhost:8080/posts")
        .then(response => {
            console.log(response.data)
            setPosts(response.data)
        })
        .finally(err => console.log(err))
    }, []);

    return (
        <div>
            <button>등록</button>
            {posts.map(post => 
                <div>
                    {post.title} : {post.content} - {post.author}
                    <button>수정</button>
                    <button>삭제</button>
                </div>
            )}
        </div>
    )
}

