import axios from 'axios';

const sample = () => {
  const handleSampleApiRequest = () => {
    axios
      .get('http://localhost:8080/hello')
      .then(res => {
        console.log(res.data);
      })
      .catch(e => {
        console.log(e);
      })
      .finally(() => {});
  };

  return (
    <div>
      sample
      <button onClick={handleSampleApiRequest}>aaa</button>
    </div>
  );
};
export default sample;
