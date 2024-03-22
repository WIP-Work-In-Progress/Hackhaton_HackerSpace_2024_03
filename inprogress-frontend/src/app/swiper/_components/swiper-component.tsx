'use client';
import { useState } from 'react'
import TinderCard from 'react-tinder-card'

// TODO - fetch data from db
const db = [
  {
    name: 'Richard Hendricks',
    url: 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/640px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg'
  },
  {
    name: 'Erlich Bachman',
    url: 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/640px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg'
  },
  {
    name: 'Monica Hall',
    url: 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/640px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg'
  },
  {
    name: 'Jared Dunn',
    url: 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/640px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg'
  },
  {
    name: 'Dinesh Chugtai',
    url: 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/640px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg'
  }
]

export default function SwiperComponent () {
  const characters = db
  const [lastDirection, setLastDirection] = useState()

  const swiped = (direction, nameToDelete) => {
    console.log('removing: ' + nameToDelete)
    setLastDirection(direction)
  }

  const outOfFrame = (name) => {
    console.log(name + ' left the screen!')
  }

  return (
    <div className='flex justify-center items-center h-screen'> 
      <div className='w-80 h-[30rem]'>
        {characters.map((character) =>
          <TinderCard key={character.name} onSwipe={(dir) => swiped(dir, character.name)} onCardLeftScreen={() => outOfFrame(character.name)}>
            <div className='swiper-person-card w-80 h-[30rem] bg-white absolute flex-col justify-between flex rounded-md overflow-hidden'>
              <img src={`${character.url}`} alt="profile-image" className='h-[30rem]'/>
              <h3 className='z-20 text-white absolute bottom-0 w-full'><span className='pl-4 pb-2'>{character.name}</span></h3>
              <div aria-label='hidden' className='swiper-person-card-overlay'></div>
            </div>
          </TinderCard>
        )}
      </div>
    </div>
  )
}