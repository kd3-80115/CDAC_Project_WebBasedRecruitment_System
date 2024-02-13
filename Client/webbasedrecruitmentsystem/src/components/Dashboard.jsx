import Header from "./common/Header"

function Base({ title = "Weclome to Get Hire", children }) {
  return (
    <>
      <Header/>
      {children}
      <h1>This is footer</h1>
    </>
  );
}

export default Base;
