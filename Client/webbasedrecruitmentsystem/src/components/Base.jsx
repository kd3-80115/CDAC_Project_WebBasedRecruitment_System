function Base({ title = "Weclome to Get Hire", children }) {
  return (
    <>
      <h1>This is Header</h1>
      {children}
      <h1>This is footer</h1>
    </>
  );
}

export default Base;
