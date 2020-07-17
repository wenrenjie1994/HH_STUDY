
export function generateTree(routes, checkedKeys) {
  if(routes == null || checkedKeys == null){
    return [];
  }

  const res = []

  for (const route of routes) {
    // console.log(route,route.children,route.children.length)
    if (route.children) {
      route.children = generateTree(route.children, checkedKeys)
    }

    // console.log(checkedKeys,route.name,checkedKeys.includes(route.name))
    if ( checkedKeys.includes(route.name) || (route.children && route.children.length >= 1)) {
      res.push(route)
    }
  }
  return res
}
