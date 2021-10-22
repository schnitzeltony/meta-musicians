require ${BPN}.inc

inherit pkgconfig features_check pack_audio_plugins qemu-ext-musicians gtk-icon-cache

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS += " \
    ${BPN}-native \
    php-native \
    cairo \
    gtk+ \
    gtk+3 \
    jack \
    libsndfile1 \
    ladspa-sdk \
    lv2 \
    libglu \
"

SRC_URI += " \
    file://0001-Makefile-align-for-oe-cross-build.patch \
    file://0002-Pass-LDFLAGS-to-so-lib-builds.patch \
"
# musl is CORRECT and causing nothing but waste of resources
SRC_URI:append:libc-musl = " \
    file://musl/0001-Hack-remove-runtime-charset-conversions.patch \
    file://musl/0002-Fix-build-with-musl.patch \
"

ARM_INSTRUCTION_SET = "arm"

COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE:armv7a = "(.*)"
COMPATIBLE_MACHINE:armv7ve = "(.*)"
COMPATIBLE_MACHINE:aarch64 = "(.*)"
COMPATIBLE_MACHINE:x86 = "(.*)"
COMPATIBLE_MACHINE:x86-64 = "(.*)"

LSP_TARGET_ARCH = ""
LSP_TARGET_ARCH:armv7a = "armv7a"
LSP_TARGET_ARCH:armv7ve = "armv7a"
LSP_TARGET_ARCH:aarch64 = "aarch64"
LSP_TARGET_ARCH:x86 = "i586"
LSP_TARGET_ARCH:x86-64 = "x86_64"

# Uncomment for trace output
#CFLAGS+="-DLSP_TRACE"
#CXXFLAGS+="-DLSP_TRACE"

EXTRA_OEMAKE += " \
    BUILD_PLATFORM=Linux \
    BUILD_PROFILE=${LSP_TARGET_ARCH} \
    PREFIX=${prefix} \
"

do_compile() {
    export CC_ARCH="${CXXFLAGS}"

    # uncomment to build/run unittest
    #UNIT_TEST="1"
    if [ "${UNIT_TEST}" = "1" ]; then
        oe_runmake clean
        oe_runmake test
        echo "QEMU unittest..."
        ${@qemu_run_binary_local(d, '${STAGING_DIR_TARGET}', '.build/lsp-plugins-test')} utest --verbose core.lspstring || echo "ERROR: QEMU unittest failed!"
        oe_runmake clean
    fi
    oe_runmake
}

do_install() {
    ${MAKE} ${EXTRA_OEMAKE} DESTDIR=${D} install
}

FILES:${PN} += " \
    ${datadir}/icons \
    ${datadir}/desktop-directories \
    ${libdir}/lsp-plugins-jack-core-${PV}.so \
"

PACKAGES =+ "${PN}-standalone"
FILES:${PN}-standalone = "${bindir}"

# lsp-plugins (and maybe others) need a gconv cache for target use of iconv
# see https://github.com/sadko4u/lsp-plugins/issues/17#issuecomment-487416107
RDEPENDS:${PN}:append:libc-glibc += " \
    glibc-gconv glibc-gconvs glibc-utils \
"
pkg_postinst_ontarget:${PN}:append:libc-glibc() {
    iconvconfig
}
