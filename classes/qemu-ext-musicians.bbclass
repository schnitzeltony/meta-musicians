inherit qemu

DEPENDS_append = " qemu-native qemu-with-timeout-native coreutils-native"

# This is an extended/modified qemu.bbclass tailored four our needs:
#
# * add qemu-native to DEPENDS: we can do that because there is no
#   introspection/interception delayed qemu usage here
# * The executable binary is set by absolute path: oe-core's qemu.bbclass
#   expects it in sysroot. Here we usually run binaries in builddir which are
#   not yet installed.
# * A recipe can set an extra library path in 'QEMU_EXTRA_LIBDIR'. This path is
#   an absolute path.
# * To catch infine qemu runs we make use of qemu-with-timeout-native which
#   hand timeouts as errors

def qemu_run_binary_local(data, rootfs_path, binary):
    libdir = rootfs_path + data.getVar("libdir")
    base_libdir = rootfs_path + data.getVar("base_libdir")
    extra_libdir = data.getVar("QEMU_EXTRA_LIBDIR")

    if extra_libdir:
        cmdline = qemu_wrapper_cmdline(data, rootfs_path, [libdir, base_libdir, extra_libdir]) + binary
    else:
        cmdline = qemu_wrapper_cmdline(data, rootfs_path, [libdir, base_libdir]) + binary
    return cmdline.replace(qemu_target_binary(data), qemu_target_binary(data) + '-timeout')
