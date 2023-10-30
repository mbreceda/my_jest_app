export function isImage(filepath) {
    const [_, extension] = filepath.split('.');
    return ['.png', '.jpg', 'jpeg'].includes(extension);
}