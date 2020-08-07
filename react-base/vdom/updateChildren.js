function updateChildren(vnode, newVnode) {
    var children = vnode.children || []
    var newChildren = newVnode.children || []

    children.forEach(function (childVnode, index){
        var newChildVnode = newChildren[index]
        if (childVnode.tag == newChildVnode.tag) {
            // 进行深层次对比， 递归
            updateChildren(childVnode, newChildVnode)
        } else {
            replaceNode(childVnode, newChildVnode)
        }
    }) 
    
}

function replaceNode(vnode, newVnode) {
    var ele = vnode.ele // 获取真实的DOM
    var newEle = createElement(newVnode)

    // 替换
    return ele
}