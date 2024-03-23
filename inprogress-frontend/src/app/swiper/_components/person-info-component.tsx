export default function PersonInfoComponent({person, fullInfo, fontColor}: {person: any, fullInfo: boolean, fontColor: string}) {
  return (
    <div className={'w-full z-20 p-4'  + ' ' + fontColor} >
      <header className={'w-full text-xl flex pb-2'}>
        <h1 className='pr-2'>{person.name},</h1>
        <span>{person.age}</span>
      </header>
      {fullInfo === true ?
      <ul>
      {person.interests.map((interest, index) => 
        <li key={index}>
          <label htmlFor="interest" className='pr-2'>{interest.interestName}:</label>
          <span>{interest.experienceInYears} lat/a</span>
        </li>            
      )}
      </ul>
        :
      <ul>
      {person.interests.slice(0, 3).map((interest, index) => 
        <li key={index}>
          <label htmlFor="interest" className='pr-2'>{interest.interestName}:</label>
          <span>{interest.experienceInYears} lat/a</span>
        </li>            
      )}
    </ul>}
    {person.interests.length > 3 && <div className='text-white text-xs'>Więcej{`(${person.interests.length - 3})`}...</div>}
  </div>
  )
}