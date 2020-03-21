require ${BPN}.inc

inherit features_check pack_audio_plugins qemu-ext-musicians gtk-icon-cache

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
    file://0003-Hack-remove-runtime-charset-conversions.patch \
"

ARM_INSTRUCTION_SET = "arm"

COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE_armv7a = "(.*)"
COMPATIBLE_MACHINE_armv7ve = "(.*)"
COMPATIBLE_MACHINE_aarch64 = "(.*)"
COMPATIBLE_MACHINE_x86 = "(.*)"
COMPATIBLE_MACHINE_x86-64 = "(.*)"

LSP_TARGET_ARCH = ""
LSP_TARGET_ARCH_armv7a = "armv7a"
LSP_TARGET_ARCH_armv7ve = "armv7a"
LSP_TARGET_ARCH_aarch64 = "aarch64"
LSP_TARGET_ARCH_x86 = "i586"
LSP_TARGET_ARCH_x86-64 = "x86_64"

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
    export LD_ARCH="`echo $LDFLAGS | sed 's:-Wl,::g'`"

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

FILES_${PN} += " \
    ${datadir}/icons \
    ${datadir}/desktop-directories \
    ${libdir}/lsp-plugins-jack-core-${PV}.so \
"

PACKAGES =+ "${PN}-standalone"
FILES_${PN}-standalone = "${bindir}"
