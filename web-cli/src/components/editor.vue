<template>
    <!-- ref配置 dom获取属性 -->
    <div ref="editorElem" class="box"></div>


</template>

<script>

    import wangeditor from 'wangeditor';

    export default {
        name: 'editor',
        data() {
            return {
                editor: null,
                editorContent: "",
            };
        },
        model: {
            prop: 'value',
            event: 'change'
        },
        props: {
            value: {
                type: String,
                default: ''
            },
            isClear: {
                type: Boolean,
                default: false
            }
        },
        watch: {
            // onEditorData(value) {
            //     console.log(value);
            // },
            isClear(val) {
                // 触发清除文本域内容
                if (val) {
                    this.editor.txt.clear()
                    this.editorContent = null
                }
            },
            value: function(value) {
                if (value !== this.editor.txt.html()) {
                    this.editor.txt.html(this.value)
                }
            }
            //value为编辑框输入的内容，这里我监听了一下值，当父组件调用得时候，如果给value赋值了，子组件将会显示父组件赋给的值

        },
        mounted() {
            //获取dom元素 this.$refs.名字  进入富文本初始化  const editor = new E('#div1')
            this.editor = new wangeditor(this.$refs.editorElem);
            //配置 onchange 函数之后，用户操作（鼠标点击、键盘打字等）导致的内容变化之后，会自动触发 onchange 函数执行
            this.editor.customConfig.onchange = (html) => {
                this.editorContent = html; //获取输入的值
                //把富文本器  里面输入的内容 传递给父组件使用数据
                console.log(this.editorContent);
                this.$emit("onEditor", this.editorContent);
                this.$emit('change', this.editorContent) // 将内容同步到父组件中
            };

            /// 默认情况下，显示所有菜单
            this.editor.customConfig.menus = [
                // 菜单配置
                "head", // 标题
                "bold", // 粗体
                "fontSize", // 字号
                "fontName", // 字体
                "italic", // 斜体
                "underline", // 下划线
                "strikeThrough", // 删除线
                "foreColor", // 文字颜色
                "backColor", // 背景颜色
                "link", // 插入链接
                "list", // 列表
                "justify", // 对齐方式
                // "quote", // 引用
                "emoticon", // 表情
                "image", // 插入图片
                "table", // 表格
                "undo", // 撤销
            ];
            //创建富文本实例
            this.editor.create();
            //创建编辑器之后，使用 editor.txt.html(...) 设置编辑器内容   重新设置编辑器内容
            // this.editor.txt.html(this.onEditorData)
        },
    };

</script>

<style type="text/css">
    .box{
        text-align: left;
    }
    .w-e-text-container{
        height: 800px !important;/*!important是重点，因为原div是行内样式设置的高度300px*/
    }


    .editor {
        width: 100%;
        margin: 0 auto;
        position: relative;
        z-index: 0;
    }
    .toolbar {
        border: 1px solid #ccc;
    }
    .text {
        border: 1px solid #ccc;
        min-height: 200px;
    }

</style>
