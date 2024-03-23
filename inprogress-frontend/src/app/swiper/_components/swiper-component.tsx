'use client';
import { useEffect, useState } from 'react'
import TinderCard from 'react-tinder-card'

// TODO - fetch data from db
const db = [
  {
    id: 1,
    name: 'Richard Hendricks',
    age: 25,
    url: 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/640px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg',
    interests: [
      {interestName: "programowanie", experienceInYears: 4},
      {interestName: "pilka nozna", experienceInYears: 3},
      {interestName: "gotowanie", experienceInYears: 2},
      {interestName: "tenis", experienceInYears: 1.5},
    ]
    
  },
  {
    id: 2,
    name: 'Erlich Bachman',
    age: 25,
    url: 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/640px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg',
    interests: [
      {interestName: "programowanie", experienceInYears: 4},
      {interestName: "pilka nozna", experienceInYears: 3},
      {interestName: "gotowanie", experienceInYears: 2},
      {interestName: "tenis", experienceInYears: 1.5},
    ]
  },
  {
    id: 3,
    name: 'Monica Hall',
    age: 25,
    url: 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/640px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg',
    interests: [
      {interestName: "programowanie", experienceInYears: 4},
      {interestName: "pilka nozna", experienceInYears: 3},
      {interestName: "gotowanie", experienceInYears: 2},
      {interestName: "tenis", experienceInYears: 1.5},
    ]
  },
  {
    id: 4,
    name: 'Jared Dunn',
    age: 25,
    url: 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/640px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg',
    interests: [
      {interestName: "programowanie", experienceInYears: 4},
      {interestName: "pilka nozna", experienceInYears: 3},
      {interestName: "gotowanie", experienceInYears: 2},
      {interestName: "tenis", experienceInYears: 1.5},
    ]
  },
  {
    id: 5,
    name: 'Dinesh Chugtai',
    age: 25,
    url: 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/640px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg',
    interests: [
      {interestName: "programowanie", experienceInYears: 4},
      {interestName: "pilka nozna", experienceInYears: 3},
      {interestName: "gotowanie", experienceInYears: 2},
      {interestName: "tenis", experienceInYears: 1.5},
    ]
  }
]

export default function SwiperComponent () {
  const [characters, setCharacters] = useState(db)
  const [lastDirection, setLastDirection] = useState()

  useEffect(() => {
    console.log(characters[0].interests.splice(3), characters[0].interests)
    console.log([1,2,3,4].slice(0, 2))
  }, [])

  const swiped = (direction, personCardId) => {
    // const personCard = document.getElementById(`person-card-${personCardId}`)
    
    switch (direction) {
      case 'left': 
        const filteredCharacters = characters.filter(character => character.id !== personCardId)
        setCharacters(filteredCharacters)
        console.log(characters)
        break;
    }
    setLastDirection(direction)
  }

  const outOfFrame = (name) => {
    console.log(name + 'left the screen!')
  }

  return (
    <div className='flex justify-center items-center h-screen overflow-hidden'> 
      <ul className='w-80 h-[30rem]'>
        {characters.map((character, index) =>
          <li key={index}>
            <TinderCard  onSwipe={(dir) => swiped(dir, character.id)} onCardLeftScreen={() => outOfFrame(character.name)}>
              <div className='swiper-person-card w-80 h-[30rem] bg-white absolute items-end flex rounded-md overflow-hidden'>
                <img src={`${character.url}`} alt="profile-image" className='h-[30rem] absolute' />
                <div className='w-full z-20 p-4'>
                  <header className='w-full text-xl flex text-white pb-2'>
                    <h1 className='pr-2'>{character.name},</h1>
                    <span>{character.age}</span>
                  </header>
                  <ul>
                    {character.interests.slice(0, 3).map((interest, index) => 
                      <li key={index} className='text-white'>
                        <label htmlFor="interest" className='pr-2'>{interest.interestName}:</label>
                        <span>{interest.experienceInYears} lat/a</span>
                      </li>            
                    )}
                  </ul>
                  {character.interests.length > 3 && <div className='text-white text-xs'>Więcej{`(${character.interests.length - 3})`}...</div>}
                </div>
                <div aria-label='hidden' className='swiper-person-card-overlay'></div>
              </div>
            </TinderCard>
          </li>
        )}
      </ul>
    </div>
  )
}